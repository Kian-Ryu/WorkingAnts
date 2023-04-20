package com.mvc.jpa.user;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

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
	public Long register(UserDTO dto, MultipartFile file) {
		String projectPath = fdir;
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
		
		return u.getUserCode();
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
	
}
