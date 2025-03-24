| 기능 | Method | URL | Request | Response | 상태 코드 |
| --- | --- | --- | --- | --- | --- |
| 일정 등록 | POST | /calender | 요청 body
{
”date”: “날짜 및 시간”,
”title”: “제목”,
”content”: “내용”
} | 등록 정보 | 200: 정상 등록 |
| 일정 목록 조회 | GET | /calender | 요청 param | 다건 응답 정보 | 200: 정상 조회 |
| 일정 조회 | GET | /calender/{id} | 요청 param | 단건 응답 정보
{
”date”: “날짜 및 시간”,
”title”: “제목”
} | 200: 정상 조회 |
| 일정 수정 | PUT | /calender/{id} | 요청 body | 수정 정보 | 200: 정상 수정 |
| 일정 삭제 | DELETE | /calender/{id} | 요청 param | - | 200: 정상 삭제 |

![Blank diagram](https://github.com/user-attachments/assets/2f1efc27-4dcd-4f2e-b902-196ed7e28ece)
