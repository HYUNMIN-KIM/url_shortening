# url_shortening
url shortening project

Url shortening 프로젝트는 긴 Url을 짧게 만들어서 짧은 url로 사용할 수 있도록 하는 프로젝트이다.


* 요구사항 정의
  1. url은 http:// 혹은 https://로 시작하는 것으로 한다.
  2. 짧은 Url과 원래 Url이 요청되었을 때 모두 요청 수 정보는 갱신된다.
  3. 짧은 url은 http://localhost/ 로 시작한다.
  4. 서버 재시작 시 모든 요청정보는 사라진다.(memory 사용)
  
  
 * 사용방법 
      git clone 
      cd url_shortening
      chmod 755 url_project.sh
      ./url_project.sh
      
      * url_project.sh가 수행하는 것.
       1. maven build
       2. 프로젝트 실행.
      
      
