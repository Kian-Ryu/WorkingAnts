package com.mvc.jpa.user;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImple implements UserService {
	
	@Autowired
	private final UserRepository repo;
	
	@Value("${users.profile}")
	String fdir;
	
	@Override
	public void register(UserDTO dto, MultipartFile file) {
		String projectPath = System.getProperty("user.dir") + fdir;
		UUID uuid = UUID.randomUUID();
		String fileName = uuid + "_" + file.getOriginalFilename();
		File f = new File(projectPath, fileName);
		log.info("서비스 연결 완료");
		try {
			file.transferTo(f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dto.setProName(fileName);
		dto.setProPath(projectPath);
		Users u = dToEntity(dto);
		repo.save(u);
		
	}
	@Override
	public UserDTO read(long userCode) {
		log.info(userCode+"서비스연결 완");
		Optional<Users> result = repo.findByUserCode(userCode);
		if(result.isPresent()) {
			Users entity = result.get();
			repo.save(entity);
		}
		return result.isPresent()?EntityToD(result.get()):null;
	}

	@Override
	public void updateReg(long userCode, String userRegion) {
		log.info(userCode+"서비스연결 완");
		Optional<Users> result = repo.findByUserCode(userCode);
		if(result.isPresent()) {
			Users entity = result.get();
			entity.changeUserRegion(userRegion);
			repo.save(entity);
		}
	}
	
	public void findByUserIdAndUserPw(String userId, String userPw) {
		repo.findByUserIdAndUserPw(userId, userPw);
	} // 로그인시 회원등록여부 파악
	
	public List<Users> UserAll() {
		return (List<Users>) repo.findAll(); // admin 관리자 페이지에서 회원정보 전체조회
	}
	
	public void deleteByUserCode(long userCode) {
		repo.deleteById(userCode); // admin 관리자 페이지에서 회원정보 삭제
	}
	@Transactional // admin 관리자 페이지에서 모달창 통해서 회원정보 수정
	public void updateUser(Users user) {
		Users existingUser = repo.findById(user.getUserCode()).orElse(null);
		if (existingUser != null) {
			existingUser.setUserRegion(user.getUserRegion());
			existingUser.setUserName(user.getUserName());
			existingUser.setUserNickName(user.getUserNickName());
			existingUser.setUserId(user.getUserId());
			existingUser.setUserPw(user.getUserPw());
			existingUser.setUserEmail(user.getUserEmail());
			existingUser.setUserPhone(user.getUserPhone());
			repo.save(existingUser);
		}
	}
	public Users findByUserEmail(String userEmail) {
		return repo.findByUserEmail(userEmail);
	}
	
}
