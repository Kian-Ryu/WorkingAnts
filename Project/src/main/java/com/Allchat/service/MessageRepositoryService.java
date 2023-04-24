package com.Allchat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Allchat.model.MessageRepository;
import com.Allchat.model.Messagerepo;
@Service
public class MessageRepositoryService {
    @Autowired
    MessageRepository mr;
	
	public Messagerepo save(Messagerepo messagerepo) {
	    // calling findOne() returns the object ... and the save() works fine
	    //Account currentAccount = accountRepository.findOne(account.getId());
	    return mr.save(messagerepo);
	}
}
