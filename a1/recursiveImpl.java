class Multiplication {
  
  static int multiply(int num1,int num2) {
    if(num1 == 0 || num2 == 0) {
      return 0;
    } else if( num2 < 0 ) {
    return - num1 + multiply(num1, num2 + 1);
    }
    else {
      return num1 + multiply(num1, num2 - 1);
    }
  }
}//
