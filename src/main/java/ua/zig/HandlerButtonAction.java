package ua.zig;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.time.LocalTime;

public class HandlerButtonAction {

    private static Service<DataContainer> service;
    private static DataContainer container = new DataContainer("", "");

    public static void handle(Label label, ProgressBar progressBar, Label labelFinish, Label labelFinishTime) {
        service = new Service<DataContainer>() {
            @Override
            protected Task<DataContainer> createTask() {
                return new Task<DataContainer>() {
                    @Override
                    protected DataContainer call() {
                        System.out.println(Thread.currentThread().getName());
                        long startTime = System.currentTimeMillis();
                        for (int i = 1; i <= MainApp.DISTANCE; i++) {
                            updateMessage("" + i);
                            updateProgress(i, MainApp.DISTANCE);
                            /*try {
                                TimeUnit.MILLISECONDS.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }*/

                        }
                        startTime = System.currentTimeMillis() - startTime;
                        container.setData1(LocalTime.now().toString());
                        container.setData2((String.valueOf(startTime)));
                        return container;
                    }
                };
            }
        };

        service.setOnSucceeded((WorkerStateEvent event1) -> {
            label.textProperty().unbind();
            labelFinish.setText(container.getData1());
            labelFinishTime.setText(container.getData2());

        });

        label.textProperty().bind(service.messageProperty());
        progressBar.progressProperty().bind(service.progressProperty());
        service.start();

    }
}
