package ug.app;

import ug.app.domain.Smartphone;

import java.time.LocalDateTime;

public class SoftwareUpdate {
    private Smartphone smartphone;
    private LocalDateTime time;

    public SoftwareUpdate(Smartphone smartphone, LocalDateTime time) {
        this.smartphone = smartphone;
        this.time = time;
    }

    public SoftwareUpdate() {
    }

    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "SoftwareUpdate{" +
                "smartphone=" + smartphone +
                ", time=" + time +
                '}';
    }
}
