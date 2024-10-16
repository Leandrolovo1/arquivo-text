package com.efigenio.models;
//import java.io.Serializable;

public class Aluno 
{
    private String nome;
    private String nascimento;
    private String cpf;
    private String email;
    private Notas notas;

    public void setNotas(Notas notas) {
        this.notas = notas;
    }

    public Notas getNotas() {
        return notas;
    }

    public Aluno(String nome, String nascimento, String cpf, String email) 
    {
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.email = email;
        this.notas = new Notas();
    }

    public String getNascimento() 
    {
        return nascimento;
    }

    public void setNascimento(String nascimento) 
    {
        this.nascimento = nascimento;
    }

    public String getCpf() 
    {
        return cpf;
    }

    public void setCpf(String cpf) 
    {
        this.cpf = cpf;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    
    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    public double calcularMedia() 
    {
        return (notas.getNota1() + notas.getNota2() + notas.getNota3() + notas.getNota4()) / 4.0;
    }

}
