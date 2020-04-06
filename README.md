# url_shortening
url shortening project

Url shortening 프로젝트는 긴 Url을 짧게 만들어서 짧은 url로 사용할 수 있도록 하는 프로젝트이다.


개발환경
JDK 1.8
Springboot v2.2.6


* 요구사항 정의
  1. url은 http:// 혹은 https://로 시작하는 것으로 한다.
  2. 짧은 Url과 원래 Url이 요청되었을 때 모두 요청 수 정보는 갱신된다.
  3. 짧은 url은 http://localhost/ 로 시작한다.
  4.http://www.musinsa.com 과 https://www.musinsa.com 은 각각 다른 짧은 url으로 반환한다.
  5. 서버 재시작 시 모든 요청정보는 사라진다.(inmemory에 저장)
  
  default 포트는 8090을 사용하였습니다. (server.port = 8090)
  
 * 사용방법 및 순서 
      1. 리눅스 상에서 해당 프로젝트를 clone 한다.(1번)
      2. clone 완료 후 해당 디렉토리인 url_shortening에 들어간다.
      3. 디렉토리 안에 url_project.sh 스크립트 파일이 있다. 해당 스크립트의 권한을 변경한다.
      4. url_project.sh 스크립트를 실행한다.
      (해당 스크립트는 메이븐으로 시스템을 빌드한 후 프로젝트 실행까지 수행한다.)
      
      * 실행순서
      1. git clone https://github.com/HYUNMIN-KIM/url_shortening.git
      2. cd url_shortening
      3. chmod 755 url_project.sh
      4. /url_project.sh
 
 
 
 
*url_project.sh가 수행하는 것
maven clean,
maven package, 
프로젝트 실행.
      
      
