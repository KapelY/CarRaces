package ua.zig;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Controller {

    @FXML
    private Label label1;
    @FXML
    private ProgressBar progressBar1;
    @FXML
    private Label labelFinish1;
    @FXML
    private Label labelFinishTime1;
    @FXML
    private Label place1;

    @FXML
    private Label label2;
    @FXML
    private ProgressBar progressBar2;
    @FXML
    private Label labelFinish2;
    @FXML
    private Label labelFinishTime2;
    @FXML
    private Label place2;

    @FXML
    private Label label3;
    @FXML
    private ProgressBar progressBar3;
    @FXML
    private Label labelFinish3;
    @FXML
    private Label labelFinishTime3;
    @FXML
    private Label place3;

    @FXML
    private Label label4;
    @FXML
    private ProgressBar progressBar4;
    @FXML
    private Label labelFinish4;
    @FXML
    private Label labelFinishTime4;
    @FXML
    private Label place4;

    @FXML
    private Label label5;
    @FXML
    private ProgressBar progressBar5;
    @FXML
    private Label labelFinish5;
    @FXML
    private Label labelFinishTime5;
    @FXML
    private Label place5;

    @FXML
    private Label label6;
    @FXML
    private ProgressBar progressBar6;
    @FXML
    private Label labelFinish6;
    @FXML
    private Label labelFinishTime6;
    @FXML
    private Label place6;


    @FXML
    public void handleButtonAction() {

        HandlerButtonAction.handle(label1, progressBar1, labelFinish1, labelFinishTime1);
        HandlerButtonAction.handle(label2, progressBar2, labelFinish2, labelFinishTime2);
        HandlerButtonAction.handle(label3, progressBar3, labelFinish3, labelFinishTime3);
        HandlerButtonAction.handle(label4, progressBar4, labelFinish4, labelFinishTime4);
        HandlerButtonAction.handle(label5, progressBar5, labelFinish5, labelFinishTime5);
        HandlerButtonAction.handle(label6, progressBar6, labelFinish6, labelFinishTime6);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                List<LabelContainer> labels = new ArrayList<>();
                labels.add(new LabelContainer(labelFinishTime1,place1 ));
                labels.add(new LabelContainer(labelFinishTime2,place2 ));
                labels.add(new LabelContainer(labelFinishTime3,place3 ));
                labels.add(new LabelContainer(labelFinishTime4,place4 ));
                labels.add(new LabelContainer(labelFinishTime5,place5 ));
                labels.add(new LabelContainer(labelFinishTime6,place6 ));

                boolean hasEmpty = true;
                while (hasEmpty) {
                    hasEmpty = false;
                    for (int i = 0; i < labels.size(); i++) {
                        if (labels.get(i).getLabelFrom().getText().trim().isEmpty()){
                            hasEmpty = true;
                            break;
                        }
                    }
                    try {

                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 0; i < labels.size(); i++) {
                    labels.get(i).setMilliseconds(labels.get(i).getLabelFrom().getText());
                }
                Collections.sort(labels, Comparator.comparing(LabelContainer::getMilliseconds));

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < labels.size(); i++) {
                            labels.get(i).getLabelTo().setText(String.valueOf(i + 1));
                        }
                    }
                });

            }
        });
        thread.start();
    }
}
