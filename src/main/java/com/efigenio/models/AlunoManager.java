package com.efigenio.models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoManager {
    private static final String ARQUIVO_ALUNOS = "alunos.txt";

    public void salvarAluno(Aluno aluno) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_ALUNOS, true))) {
            oos.writeObject(aluno);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> carregarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_ALUNOS))) {
            while (true) {
                alunos.add((Aluno) ois.readObject());
            }
        } catch (EOFException e) {
            // Fim do arquivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return alunos;
    }
}
