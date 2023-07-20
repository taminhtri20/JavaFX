package com.example.ungdungquanlydiemso;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, Integer> id;
    @FXML
    private TableColumn<Student, String> name;
    @FXML
    private TableColumn<Student, String> clasS;
    @FXML
    private TableColumn<Student, String> gender;
    @FXML
    private TableColumn<Student, String> address;
    @FXML
    private TableColumn<Student, Integer> score;

    private final ObservableList<Student> data = FXCollections.observableArrayList(
            new Student(1,"Tri","IBSK1D1","Nam","Ha noi",8),
            new Student(2,"Minh","IBSK1D1","Nu","ha noi",9),
            new Student(3,"Ha","IBSK1D1","Nam","Ha noi",10),
            new Student(4,"Ly","IBSK1D1","Nam","Ha noi",8),
            new Student(5,"Vinh","IBSK1D1","Nu","ha noi",9),
            new Student(6,"Anh","IBSK1D1","Nam","Ha noi",10),
            new Student(7,"Dung","IBSK1D1","Nam","Ha noi",8),
            new Student(8,"Bang","IBSK1D1","Nu","ha noi",9),
            new Student(9,"Tien","IBSK1D1","Nam","Ha noi",10),
            new Student(10,"Thuan","IBSK1D1","Nam","Ha noi",10)
            );

    @Override
    public void initialize(URL Location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        clasS.setCellValueFactory(new PropertyValueFactory<Student,String>("clasS"));
        gender.setCellValueFactory(new PropertyValueFactory<Student, String>("gender"));
        address.setCellValueFactory(new PropertyValueFactory<Student, String>("address"));
        score.setCellValueFactory(new PropertyValueFactory<Student,Integer>("score"));

        tableView.setItems(data);
    }

    @FXML
    private TextField idtf;
    @FXML
    private TextField nametf;
    @FXML
    private TextField classtf;
    @FXML
    private RadioButton nam;
    @FXML
    private RadioButton nu;
    @FXML
    private ToggleGroup toogle;
    @FXML
    private TextField addresstf;
    @FXML
    private TextField scoretf;


    @FXML
    protected void add(){
        RadioButton button = (RadioButton) toogle.getSelectedToggle();
        Student student = new Student();
        student.setId(Integer.parseInt(idtf.getText()));
        student.setName(nametf.getText());
        student.setClasS(classtf.getText());
        student.setGender(button.getText());
        student.setAddress(addresstf.getText());
        student.setScore(Integer.parseInt(scoretf.getText()));
        data.add(student);
    }
    @FXML
    protected void remove(){
        Student selected = tableView.getSelectionModel().getSelectedItem();
        data.remove(selected);
    }
    @FXML
    protected void update(){
        RadioButton button = (RadioButton) toogle.getSelectedToggle();

        ObservableList<Student> students = tableView.getItems();
        int idStudent = Integer.parseInt(idtf.getText());

        for (Student student : students){
            if (student.getId() == idStudent){
                student.setId(Integer.parseInt(idtf.getText()));
                student.setName(nametf.getText());
                student.setClasS(classtf.getText());
                student.setGender(((RadioButton) toogle.getSelectedToggle()).getText());
                student.setAddress(addresstf.getText());
                student.setScore(Integer.parseInt(scoretf.getText()));

                tableView.setItems(students);
                tableView.refresh();
            }
        }
    }
    @FXML
    protected void rowclicked(){
        RadioButton button = (RadioButton) toogle.getSelectedToggle();

        Student clickStudent = tableView.getSelectionModel().getSelectedItem();
        idtf.setText(String.valueOf(clickStudent.getId()));
        nametf.setText(String.valueOf(clickStudent.getName()));
        classtf.setText(String.valueOf(clickStudent.getClasS()));
        addresstf.setText(String.valueOf(clickStudent.getAddress()));
        scoretf.setText(String.valueOf(clickStudent.getScore()));
    }
}