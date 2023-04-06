import java.util.*;
//Math.random() 0 과 1사이에 double타입 난수 생성
public class Main {
    public static void main(String[] args) {
        int[] intArray = new int[3];
        //(0~10)까지 랜덤한 한자리수 생성
        int first_num = (int)(Math.random()*10);
        int second_num;
        int third_num;
        //자리수에 같은 수가 안들어가도록 반복문실행
        while(true){
            second_num = (int)(Math.random()*10);
            if(first_num != second_num){
                break;
            }
        }
        while(true){
            third_num = (int)(Math.random()*10);
            if(first_num != third_num && third_num != second_num ){
                break;
            }
        }
        //값을 배열에 집어넣어줌
        intArray[0] = first_num;
        intArray[1] = second_num;
        intArray[2] = third_num;
        //자리수 합치기위해 Integer.toString으로 int값을 String값으로 변환해주어 문자열 합치기
        String baseball = Integer.toString(intArray[0])+Integer.toString(intArray[1])+Integer.toString(intArray[2]);
        //정답확인
        System.out.println(baseball);
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        Scanner sc = new Scanner(System.in);
        //정답 String 변수 선언
        String answer;
        //시도 횟수 변수 선언
        int count = 1;
        while(true){
            answer = sc.next();
            // B,S개수를 출력해주기 위해 변수 설정
            int strike = 0;
            int ball = 0;
            //입력된 string을 한글자씩 list에 넣는다
            String[] list = answer.split("");
            //입력값 잘못입력시 출력해주는 부분 continue;를 통해 다시 while문 돌도록 하였음.
            if (list.length != 3){
                System.out.println("3자리 숫자를 입력해주세요");
                continue;
            }

            if (Objects.equals(list[0], list[1]) || Objects.equals(list[0], list[2])  || Objects.equals(list[1], list[2]) ){
                System.out.println("중복되는 숫자는 입력하지 마세요");
                continue;
            }


            // 배열 두개 이중반복문 실행(더쉽게 하는 방법이 있을까?)
            for (int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    //입력값을 문자로 받았기에 문자열로 변환하여 비교
                    if(Objects.equals(Integer.toString(intArray[i]),list[j])){
                        if(i == j){
                            strike++;
                        }
                        else{
                            ball++;
                        }
                    }
                }
            }
            //정답과 내가 입력한 숫자가 같다면 출력
            if (Objects.equals(baseball, answer)){
                System.out.println(count + "번째 시도 : " + answer+"\n3S");
                System.out.println(count+"번만에 맞히셨습니다.\n게임을 종료합니다.");
                break;
            }
            //정답이 아닐시 출력
            else{
                System.out.println(count + "번째 시도 : " + answer);
                //3B일 경우 3만 출력하기 위하여
                if(Objects.equals(ball, 3)){
                    System.out.println(ball+"B");
                }
                else{
                    System.out.println(ball+"B"+strike+"S");
                }
                //시도횟수 증가
                count++;
            }
        }
    }
}
