package com.mbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbs.dao.MemberDao;
import com.mbs.dto.MemberDto;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao dao;
	
	@Override
	public void joinObject(MemberDto dto) throws Exception{
		
		dao.join(dto);
		
	}

	@Override
	public MemberDto loginObject(MemberDto dto) throws Exception {
		return dao.login(dto);
	}

	//Controller에서 보내느 파라미터들을 memberUpdate(MemberDto dto)로 받고
	@Override
	public void memberUpdate(MemberDto dto) throws Exception {
		//받은 dto를 DAO로 보내줍니다.
		dao.memberUpdate(dto);
		
	}

	
}
