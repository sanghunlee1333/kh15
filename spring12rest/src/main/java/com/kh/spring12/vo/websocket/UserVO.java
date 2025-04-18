package com.kh.spring12.vo.websocket;

import java.sql.Timestamp;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//사용자에게 공개될 유저의 정보
@Data @Builder @NoArgsConstructor @AllArgsConstructor
//@EqualsAndHashCode(of = "accountId") //ID가 같으면 같은 인스턴스 취급해라
public class UserVO {
	private String accountId;
	private String accountNickname;
	private String accountLevel;
	private String accountEmail;
	private Timestamp accountJoin;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		return Objects.equals(accountId, other.accountId);
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountId);
	}
}
