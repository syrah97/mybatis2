package com.mbs.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mbs.dto.MemberDto;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession session;

	private static String namespace="com.mbs.mapper.MemberMapper.";
	
	@Override
	public void join(MemberDto dto) throws Exception{
		session.insert(namespace+"join",dto);
		
		
	
	}

	@Override
	public MemberDto login(MemberDto dto) throws Exception {
		
		return session.selectOne(namespace+"login",dto);
	}
	
	//서비스에서 보낸 파라미터들을 memberUpdate(MemberDto dto)에 담습니다.
	@Override
	public void memberUpdate(MemberDto dto) throws Exception {
		// dto에 담긴 파라미터들은 memberMapper.xml에 memberMapper라는 namespace에
		// 아이디가 memberUpdate인 쿼리에 파라미터들을 넣어줍니다.
		session.update("MemberMapper.memberUpdate",dto);
		
	}
	

}
