package com.mbs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
	
	
	private String userId;
	private String userPass;
	private String userName;
	private String userPnum;
	
}
