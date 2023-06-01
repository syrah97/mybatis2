package com.mbs.dao;

import com.mbs.dto.MemberDto;

public interface MemberDao {
	
	//회원가입
	public void join(MemberDto dto) throws Exception;
	
	//로그인
	public MemberDto login(MemberDto dto) throws Exception;
	
	//회원정보 수정
	public void memberUpdate(MemberDto dto) throws Exception;
}
