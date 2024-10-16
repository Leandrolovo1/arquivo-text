package com.efigenio.models;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerLista {
    @FXML
    private ListView<String> listaAlunos;

    @FXML
    private void initialize() {
        List<Aluno> alunos = carregarAlunos();
        for (Aluno aluno : alunos) {
            listaAlunos.getItems().add(aluno.getNome() + " - Média: " + aluno.calcularMedia());
        }
    }

    private List<Aluno> carregarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("alunos.txt"))) {
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
