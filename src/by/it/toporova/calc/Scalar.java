package by.it.toporova.calc;

class Scalar extends Var{
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) { //создание конструктора alt+insert
        this.value = value; //констр.будет принимать на вход значение и заносить его во внутреннее поле
    }

    @Override
    public Var add(Var other) throws CalcException {//по умолчанию при вызове констркутора метод вставляется в поведение предка "return super.add(other)". но нам нужно изменить
        if(other.toString().matches(Patterns.SCALAR)){
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        }
        else //5 + vector -->vector.add(5) - если other был вектором, то add ищем в векторе
            //5 + matrix -->matrix.add(5) - если other был матрицей, то add ищем в матрице
            return  other.add(this); //add будет искаться в конкретной реализации other

    }

    @Override
    public Var sub(Var other)throws CalcException {
        if(other.toString().matches(Patterns.SCALAR)){
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        }
        else
            return  new Scalar(-1).mul(other).add(this); //add будет искаться в конкретной реализации other

    }

    @Override
    public Var mul(Var other)throws CalcException {
        if(other.toString().matches(Patterns.SCALAR)){
            double mul = this.value*((Scalar) other).value;
            return new Scalar(mul);
        }
        else
            return  other.mul(this); //add будет искаться в конкретной реализации other

    }

    @Override
    public Var div(Var other) throws CalcException{
        if((other.toString().matches(Patterns.SCALAR))&& ((Scalar) other).value!=0){
            double div = this.value/((Scalar) other).value;
            if (div == 0){
                throw new CalcException("деление на 0");
            }
            return new Scalar(div);
        }
        else
            return  other.div(this); //add будет искаться в конкретной реализации other

    }

    Scalar(String str){
         this.value=Double.parseDouble(str);
    }
    Scalar(Scalar scalar){ //прием экземпляра класса
         this.value=scalar.value; //обращение к классу скаляр
    }

    @Override
    public String toString() { //переопределение метода
        return Double.toString(value);
    }


}
