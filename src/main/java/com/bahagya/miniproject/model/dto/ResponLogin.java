package com.bahagya.miniproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponLogin {
	private String user_role;
	private boolean status;
	private String fullname;
	private String username;
}
