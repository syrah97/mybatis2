package com.mbs.service;

import com.mbs.dto.MemberDto;

public interface MemberService {
	
	public void joinObject(MemberDto dto) throws Exception;
	
	public MemberDto loginObject(MemberDto dto) throws Exception;
	
	public void memberUpdate(MemberDto dto) throws Exception;
	
}
