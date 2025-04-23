package com.kh.spring12.error;

//'대상(타겟)을 찾지 못했을 때' 던지는 사용자 정의 예외(Custom Exception) 클래스
public class TargetNotFoundException extends RuntimeException {

	//- 파라미터 없는 기본 생성자
	//내부적으로 RuntimeException의 기본 생성자(super())를 호출해서 예외 객체를 만듦.
	
	//[1] Checked Exception	-> Exception 직계 자식 (단, RuntimeException 계열 제외)
	// - ex) IOException 등 메서드 선언부에 반드시 throws 써야 하고, 호출하는 쪽에서도 반드시 try/catch 하거나 다시 던져야 함
	// 즉, Checked: 메서드 선언부에 throws를 반드시 적어야 하고, 호출할 때 반드시 try/catch로 처리하거나 또 던져야 함
	
	//[2] Unchecked Exception -> RuntimeException 직계 자식 (여기엔 TargetNotFoundException도 포함)
	// - try/catch 안 해도 됨, 선언부에 throws 안 써도 됨
	// 즉, Unchecked: RuntimeException 계열은 신경 쓰지 않아도 됨. 메서드에 throws를 안 적어도 되고, 호출하는 곳에서 잡아주지 않아도 컴파일이 통과됨
	
	public TargetNotFoundException() {
		super();
	}

	//- 메시지를 받는 생성자
	// 예외를 던질 때 "존재하지 않는 방 번호"처럼 설명 문구(message)를 함께 전달할 수 있음
	// super(message)가 그 문구를 부모 클래스(RuntimeException)에 넘겨서, 나중에 e.getMessage()로 꺼내볼 수 있음
	public TargetNotFoundException(String message) {
		super(message);
	}
	
	/*
		ex) DB에서 roomNo로 방 정보를 조회했는데 결과가 없을 때
		RoomDto room = roomDao.selectOne(roomNo);
		if (room == null) {
		    throw new TargetNotFoundException("존재하지 않는 방 번호: " + roomNo);
		}
		-> 이렇게 던져두면, 컨트롤러나 전역 예외 핸들러가 잡아서 404 Not Found 응답으로 바꿔줄 수도 있음
		-> 여기서 @ControllerAdvice 등으로 잡아주면 -> 404 Not Found 같은 원하는 HTTP 상태 코드를 반환할 수 있어요.
		(참고) @ControllerAdvice를 쓰면?
		-> 글로벌(모든 컨트롤러에 적용) 예외 처리기를 만들어서 특정 예외 타입을 잡아서(@ExceptionHandler),
		   원하는 HTTP 상태(예: 404)와 커스텀 뷰(HTML 페이지) 또는 JSON 바디를 반환할 수 있음
		
		#만약 DB 조회 결과가 null인데 다음 코드에서 그 객체를 바로 쓰면
		RoomDto room = roomDao.selectOne(roomNo);
		String name = room.getName();  // room이 null이면 여기서 NPE 발생
		-> 여기서 터지는 건 NullPointerException 이고, 스프링 기본 예외 처리에 따라 500 Internal Server Error 응답 발생
	*/
	
}
