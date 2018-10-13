import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0, unit, dozens, hundreds;
        String stringMessage = "", str;
        boolean isContinue = true;
        do {
            do {
                System.out.print("\nEnter a number: ");
                number = scanner.nextInt();

                if(!isAcceptableNumber(number)){
                    System.out.println("\nOut of ability!! ");
                }
            }while (!isAcceptableNumber(number));

            //Case one digit number
            if(isOneDigitNumber(number)){
                stringMessage = getMessageOneDigitNumber(number);
            }

            //Case two digit number
            if(isTwoDigitNumber(number)){
                stringMessage = getMessageTwoDigitNumber(number);
            }

            //Case three digit number
            if(isThreeDigitNumber(number)){
                stringMessage = getMessageThreeDigitNumber(number);
            }

            //Test
            System.out.println(stringMessage);


            System.out.println("Do you want to continue(Y/N)");
            str = scanner.next();
            if(str.toLowerCase().equals("n")){
                isContinue = false;
            }
        }while (isContinue);

    }

    public static String getMessageThreeDigitNumber(int number){
        String stringMessage = "";
        int hundreds = number / 100;
        int dozens = (number % 100) / 10;
        int unit = (number % 100) % 10;
        boolean isDozensEquals0 = dozens==0?true:false;
        boolean isNumberEquals100 = number==100?true:false;
        if(isNumberEquals100){
            stringMessage += getMessageOneDigitNumber(hundreds) + " hundred ";
        }
        else if(!isDozensEquals0){
            stringMessage += getMessageOneDigitNumber(hundreds) + " hundred and "
                    +getMessageTwoDigitNumber(dozens*10+unit).toLowerCase();
        }else if(isDozensEquals0){
            stringMessage += getMessageOneDigitNumber(hundreds) + " hundred and "
                    +getMessageOneDigitNumber(unit).toLowerCase();
        }
        return stringMessage;
    }


    public static String getMessageTwoDigitNumber(int number){
        String stringMessage = "";
        int dozens = number/10;
        int unit = number%10;
        boolean isDevisibleBy10 = number%10==0?true:false;
        boolean isFrom10To20 = number>10&&number<20?true:false;
        boolean isEquals10 = number==10?true:false;
        boolean isEquals11 = number==11?true:false;
        boolean isEquals12 = number==12?true:false;
        boolean isEquals13 = number==13?true:false;
        boolean isEquals15 = number==15?true:false;
        boolean isEquals20 = number==20?true:false;
        boolean isEquals30 = number==30?true:false;
        boolean isEquals50 = number==50?true:false;
        boolean isDozensEquals2 = dozens==2?true:false;
        boolean isDozensEquals3 = dozens==3?true:false;
        boolean isDozensEquals5 = dozens==5?true:false;

        if(isDevisibleBy10){
            if(isEquals10){
                stringMessage = "Ten";
            }
            else{
                if(isEquals20){
                    stringMessage = "Twen";
                }
                if(isEquals30){
                    stringMessage = "Thir";
                }
                if(isEquals50){
                    stringMessage = "Fif";
                }
                else if(!isEquals20&&!isEquals30&&!isEquals50){
                    stringMessage = getMessageOneDigitNumber(number);
                }
                stringMessage+="ty";
            }
        }

        if(isFrom10To20){
            if(isEquals11){
                stringMessage = "Eleven";
            }
            if(isEquals12){
                stringMessage = "Twelve";
            }else if(!isEquals11&&!isEquals12){
                if(isEquals13){
                    stringMessage = "Thir";
                }
                if(isEquals15){
                    stringMessage = "Fif";
                }else if(!isEquals13&&!isEquals15){
                    stringMessage = getMessageOneDigitNumber(number);
                }
                stringMessage+="teen";
            }
        }

        else if(!isDevisibleBy10&&!isFrom10To20){
            if(isDozensEquals2){
                stringMessage = "Twen";
            }
            if(isDozensEquals3){
                stringMessage = "Thir";
            }
            if(isDozensEquals5){
                stringMessage = "Fif";
            }
            else if(!isDozensEquals2&&!isDozensEquals3&&!isDozensEquals5){
                stringMessage = getMessageOneDigitNumber(dozens);
            }
            stringMessage+="ty " + getMessageOneDigitNumber(unit).toLowerCase();
        }

        return stringMessage;
    }

    public static String getMessageOneDigitNumber(int number){
        String stringMessage ="";
        switch (number){
            case 0:
                stringMessage = "Zero";
                break;
            case 1:
                stringMessage = "One";
                break;
            case 2:
                stringMessage = "Two";
                break;
            case 3:
                stringMessage = "Three";
                break;
            case 4:
                stringMessage = "Four";
                break;
            case 5:
                stringMessage = "Five";
                break;
            case 6:
                stringMessage = "Six";
                break;
            case 7:
                stringMessage = "Seven";
                break;
            case 8:
                stringMessage = "Eight";
                break;
            case 9:
                stringMessage = "Nine";
                break;
        }
        return stringMessage;
    }

    public static boolean isAcceptableNumber(int n){
        return n>0&&n<1000?true:false;
    }

    public static boolean isPositiveNumber(int n){
        return n>0?true:false;
    }

    public static boolean isThreeDigitNumber(int n){
        return n>99&&n<1000?true:false;
    }

    public static boolean isOneDigitNumber(int n){
        return n>=0&&n<10?true:false;
    }

    public static boolean isTwoDigitNumber(int n){
        return n>9&&n<100?true:false;
    }
}
