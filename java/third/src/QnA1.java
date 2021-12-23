public class QnA1 {
    public static void main(String[] args) {
        // 65 ~ 90, 97 ~ 122 무작위 난수
        // final은 상수값을 지정
        // 상수값을 지정할때는 변수명은 전부 대문자 만든다.
        // (부가적인 관습이라면 아래와 같은 사항들이 있음)
        // class 이름은 시작이 무조건 대문자
        // 만약 다중 단어로 구성된다면 단어 이니셜마다 대문자로 구성한다.
        // 변수나 매서드(함수)의 경우엔
        // 시작은 소문자 이후 class와 마찬가지로
        // 다중 단어로 구성된 경우 시작 소문자 이후 나머지는 이니셜마다 대문자로 구성
        final int MAX1 = 90;
        final int MIN1 = 65;

        final int MAX2 = 97;
        final int MIN2 = 122;

        // 범위: 최대값 - 최소값 + 1 (난수가 나타나는 범위)
        int range = MAX1 - MIN1 + 1;
        int rand = (int) (Math.random() * range + MIN1);
        System.out.println("65 ~ 90 사이의 무작위 난수: " + rand);

        range = MAX2 - MIN2 + 1;
        rand = (int) (Math.random() * range + MIN2);
        System.out.println("97 ~ 122 사이의 무작위 난수: " + rand);
    }
}

// Q. final을 사용하니까 오히려 입력할게 많아지고 귀찮은데 왜 써야 하나요 ?
/* A.
      예를 들어서 어떤 생산 라인(공장)을 관리하는 시스템이 있다고 가정한다.
      현재 공장 라인은 7개가 있기 때문에
      코드에는 모두 7이라는 숫자를 직접 입력하여 개발되어 있다.
      
      ex)
      if (num == 7) {
        blabla ~~~
      }
      
      // 6번 라인을 의도한 부분임
      if (line == num - 1) {
        // 특수 공정 진행
      }
      
      이번에 신규 사업을 따내면서 설비를 증설하고자 한다.
      대규모 사업 입찰을 받았으므로 새로운 라인을 5개를 추가한다.
      그런데 코드를 이미 수십만줄 개발해놨다.
      어떻게 해야할까 ?

      예로 final int NUM = 7;
      이런 경우 7과 관련한 메커니즘이 아닌
      좀 더 일반화된 형식으로 코드를 작성할 수 있었을 것이고
      만약 라인 수가 변경되면 7을 전부 찾아서 없애는 것이 아닌
      final int NUM = 7; <<<--- 을 그냥 12로 바꾸면 끝난다.
      그럼 위의 6번 라인은 어떻게 해야 하나 ?

      final int SPECIAL_PROCESS = 6;

      if (SPECIAL_PROCESS == num) 으로 처리하면 된다.
      나중에 추가 설비를 달면서 6번 공정을 바꾸고 이것을 8번으로 바꾼다 하더라도

      final int SPECIAL_PROCESS = 8; 로 바꾸면 그만이다.
      수천개의 파일, 수만 ~ 수십만 라인의 경우에도
      final을 사용해서 관리하면 단순히 숫자만 바꿔도
      모든 파일과 모든 코드에 이를 적용할 수 있다는 이점이 있다.
 */

// Q. final이 유지보수에 좋은것은 알겠음
//    final int와 그냥 int에 어떤 차이가 있는가요 ?
/* A.
      final은 상수를 만듭니다.
      그렇기 때문에 final int MAX = 5를 했을 경우 변경이 불가능합니다.

      ex)

      final int MAX = 5;

      if (MAX ~~~) {
        ~~~~
      }

      factory.process(vehicle, MAX - 2);
      ~~~~

      이 사이에 1000줄이 있음

      if (~~~~) {
        여기서 에러가 발생함

        상황 가정!
        에러가 발생한 이유는 MAX값이 4여야 하는데
        현재 MAX값이 5이기 때문에 에러가 발생했음

        MAX = 4; <<<--- 대규모 문제는 여기서 발생함
                    --- 내가 만든 프로그램은 바꾸면 잘 돌아감
                    --- 근대 우리 팀이 만든 프로그램들은 어떻게 될까 ???
                    --- 우리 팀도 이 로직을 공통적으로 쓰고 있었는데
                    --- 내가 MAX값을 무조건 4로 박아버렸으니
                    --- 다른 팀원들이 사용하는 값도
                    --- 무조건 MAX = 4로 처리되지 않을까 ?
                    --- 원래는 2, 3, 4, ~ 100 등등 다양하게 들어가야하는데
                    --- 그냥 4를 때려박으므로써 초토화가 발생함
                    --- (갑자기 되던 것들이 전부 안돌아가기 시작함)
                    --->>> 서버가 뻗고, 사용자들이 탈출하고
                    --->>> 민원실로 전화가 솟구치고, 매출이 감소하고
                    --->>> 야근이 발생하고, 집에 못가고, 회사에 살림 차리고 ....
                    --->>> 빠르면 몇 주, 길면 몇 달만에 문제를 찾아냄
                    --->>> 알고보니 MAX를 바꿔서 발생한 문제

                    --->>> 이것을 원천적으로 막을 수 있다면 써야할까요 말아야 할까요 ?
        ~~~~ 진행 (에러 없음)
      }
 */

// final을 사용하는 이유와 random: range + min 구조