/*
 * package com.mvc.jsp.work;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service; import
 * org.springframework.transaction.PlatformTransactionManager; import
 * org.springframework.transaction.TransactionStatus; import
 * org.springframework.transaction.annotation.Transactional; import
 * org.springframework.transaction.support.DefaultTransactionDefinition;
 * 
 * @Service
 * 
 * @Transactional public class WorkService { WorkVo wVo;
 * 
 * @Autowired WorkMapper mapper;
 * 
 * @Autowired PlatformTransactionManager manager; TransactionStatus status;
 * 
 * public boolean insert(WorkVo vo){ boolean b = false; status =
 * manager.getTransaction(new DefaultTransactionDefinition()); Object savePoint
 * = status.createSavepoint();
 * 
 * int cnt=0; cnt = mapper.insert(vo); System.out.println("서비스 실행! cnt:"+cnt);
 * if(cnt>0) { b = true; manager.commit(status); //wVo =
 * mapper.view(vo.getListCode()); }else { status.rollbackToSavepoint(savePoint);
 * } return b; }
 * 
 * public WorkVo getwVo() { return wVo; } }
 */