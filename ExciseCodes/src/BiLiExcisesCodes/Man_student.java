package BiLiExcisesCodes;

/**
 * @Auther: YS(E11)
 * @Date: 2021/4/26
 * @Description: 子类
 * @Version: 1.0
 */
public class Man_student extends Man {
    private int sno;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public Man_student(){

    }

    public Man_student(String name, int age, int sno){
        super.setName(name);
        super.setAge(age);
        this.setSno(sno);
//        this.sno = sno;
//        this.setName(name);
//        this.setAge(age);
    }

}
