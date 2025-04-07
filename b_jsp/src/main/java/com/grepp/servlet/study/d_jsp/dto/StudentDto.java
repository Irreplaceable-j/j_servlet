package com.grepp.servlet.study.d_jsp.dto;

public class StudentDto {
    private String name;
    private Integer kor;
    private Integer math;
    private Integer eng;
    private Integer develop;
    
    public StudentDto() {
    }
    
    public StudentDto(String name, Integer kor, Integer math, Integer eng, Integer develop) {
        this.name = name;
        this.kor = kor;
        this.math = math;
        this.eng = eng;
        this.develop = develop;
    }
    
    public int getSum(){
        return kor + math + eng + develop;
    }
    
    public int getAvg(){
        return getSum()/4;
    }
    
    @Override
    public String toString() {
        return "StudentDto{" +
                   "name='" + name + '\'' +
                   ", kor=" + kor +
                   ", math=" + math +
                   ", eng=" + eng +
                   ", develop=" + develop +
                   '}';
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getKor() {
        return kor;
    }
    
    public void setKor(Integer kor) {
        this.kor = kor;
    }
    
    public Integer getMath() {
        return math;
    }
    
    public void setMath(Integer math) {
        this.math = math;
    }
    
    public Integer getEng() {
        return eng;
    }
    
    public void setEng(Integer eng) {
        this.eng = eng;
    }
    
    public Integer getDevelop() {
        return develop;
    }
    
    public void setDevelop(Integer develop) {
        this.develop = develop;
    }
}
