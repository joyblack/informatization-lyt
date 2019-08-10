package com.xxfy.informatizationlyt.user.domain.repository;

import com.xxfy.informatizationlyt.common.repository.BaseRepository;
import com.xxfy.informatizationlyt.user.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends BaseRepository<UserEntity> , JpaRepository<UserEntity, Long> {

    UserEntity getAllByLoginNameAndPassword(String loginName, String password);

    UserEntity getAllByPhoneAndPassword(String phone, String password);

    UserEntity getAllByIdNumberAndPassword(String idNumber, String password);

    UserEntity findAllByPhoneAndIdNot(String phone, Long id);

    UserEntity findAllByIdNumberAndIdNot(String idNumber, Long id);

    UserEntity findAllByLoginNameAndIdNot(String loginName, Long id);
}
