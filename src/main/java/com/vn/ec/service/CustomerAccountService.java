package com.vn.ec.service;

import com.vn.ec.common.Constants;
import com.vn.ec.common.exception.RecordNotFoundException;
import com.vn.ec.dto.request.API19ChangePwdRequest;
import com.vn.ec.dto.request.API21ResetPwdRequest;
import com.vn.ec.entity.CustomerAccount;
import com.vn.ec.repository.CustomerAccountRepository;
import com.vn.ec.repository.CustomerProfilesRepository;
import com.vn.ec.utlis.DateTimeUtils;
import com.vn.ec.utlis.EncryptAndDecrypt;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerAccountService {

    private final CustomerAccountRepository customerAccountRepository;
    private final CustomerProfilesRepository customerProfilesRepository;
    public boolean deleteAccount(Long id) {
        CustomerAccount customerAccount = customerAccountRepository.findByIdAndDeleteFlag(id, Constants.DELETE_FALSE)
                .orElseThrow(()-> new RecordNotFoundException("user account not fount"));
        customerAccount.setCommonDelete(id);
        customerAccountRepository.save(customerAccount);
        return true;
    }

    public boolean deleteAccountV2(Long id) {
        CustomerAccount customerAccount = customerAccountRepository.getbyid(id);
        if (customerAccount==null){
            throw new RecordNotFoundException("user account not fount");
        }
        customerAccount.setCommonDelete(id);
        customerAccountRepository.save(customerAccount);
        return true;
    }
    @SneakyThrows
    public String changePassword(API19ChangePwdRequest req) {

        Optional<CustomerAccount> storageData = customerAccountRepository.findByIdAndDeleteFlag(req.getUserId(),
                Constants.DELETE_FALSE); // tìm kiếm theo id và lấy ra tu bảng account
        if (storageData.isEmpty()) { //nếu rỗng th trả về Notification
            return "user not found";
        }
        CustomerAccount account = storageData.get(); //lấy thông tin vừa tìm được của tài khoản trong bảng account
        String password = EncryptAndDecrypt.decrypt(account.getLoginPassword(),
                Constants.PASSWORD_AIR_WATER_DE); // giai ma mậ khẩu vùa nhận từ tài khoản
        if (!password.equals(req.getOldPassword())) {
            return "password aren't matches";
        } // so sánh pass vừa lấy ra từ data với pass "cũ" được  nhập vào từ trong req, khác sẽ hiện Notification báo lỗ
        if(password.equals(req.getNewPassword())) {
            return  "the new password cannot be the same as the old password";
        } //so sánh pass trong data với pass "mới" được nhập vào từ trong req, giốôngsex hiện Notification báo lỗi
        String encodedNewPwd = EncryptAndDecrypt.encrypt(req.getNewPassword().getBytes(StandardCharsets.UTF_8),
                Constants.PASSWORD_AIR_WATER_DE);// mã hoá pass mới
        account.setLoginPassword(encodedNewPwd); // sửa vào dòng data
        account.setCommonUpdate(req.getUserId());// thêm thoong tin vào common
        customerAccountRepository.save(account); // luu vào bảng
        return "success change password";
    }
    @SneakyThrows
    public String resetPassword(API21ResetPwdRequest req) {
        Optional<CustomerAccount> store = customerAccountRepository.findByLoginIdAndDeleteFlag(req.getLoginId(),
                Constants.DELETE_FALSE); // tìm kiếm theo id và feleteflag sau đo lấy ra data gói vào Optional
        if (store.isEmpty()) {
            return "login_id is not exits";
        } //nếu data lấy ra là rỗng thì gưi câu Notification báo lỗi
        CustomerAccount account = store.get(); // lấy data trong thùng lưu vào biến (Optional=thùng chứa)
        String encodedNewPwd = EncryptAndDecrypt.encrypt(req.getPassword().getBytes(StandardCharsets.UTF_8),
                Constants.PASSWORD_AIR_WATER_DE); // mã hoá mật khẩu "mới" lấy từ req
        account.setLoginPassword(encodedNewPwd);// thiết lập pass đã mã hoá vào data
        account.setUpdatedAt(DateTimeUtils.resultTimestamp()); //thiết lập thời gian cập nhật
        customerAccountRepository.save(account); //lưu data vào bảng account
        return "reset password success";
    }// api này là bước sau của bước gửi otp để reset password
}
