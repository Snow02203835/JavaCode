package expense;

import java.time.LocalDate;

public class Item {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getWorkerNum() {
        return workerNum;
    }

    public void setWorkerNum(String workerNum) {
        this.workerNum = workerNum.trim();
    }

    public String getOrderSN() {
        return orderSN;
    }

    public void setOrderSN(String orderSN) {
        this.orderSN = orderSN.trim();
    }

    public double getTraffic() {
        return traffic;
    }

    public void setTraffic(double traffic) {
        this.traffic = traffic;
    }

    public double getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(double accommodation) {
        this.accommodation = accommodation;
    }

    public double getMeal() {
        return meal;
    }

    public void setMeal(double meal) {
        this.meal = meal;
    }

    public double getTravel() {
        return travel;
    }

    public void setTravel(double travel) {
        this.travel = travel;
    }

    public double getPrint() {
        return print;
    }

    public void setPrint(double print) {
        this.print = print;
    }

    public double getTeam() {
        return team;
    }

    public void setTeam(double team) {
        this.team = team;
    }

    public double getSpecialTraffic() {
        return specialTraffic;
    }

    public void setSpecialTraffic(double specialTraffic) {
        this.specialTraffic = specialTraffic;
    }

    public double getSelfDrive() {
        return selfDrive;
    }

    public void setSelfDrive(double selfDrive) {
        this.selfDrive = selfDrive;
    }

    public double getExpress() {
        return express;
    }

    public void setExpress(double express) {
        this.express = express;
    }

    public double getDaily() {
        return daily;
    }

    public void setDaily(double daily) {
        this.daily = daily;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private String name;
    private String workerNum;
    private String orderSN;
    private double traffic;
    private double accommodation;
    private double meal;
    private double travel;
    private double print;
    private double team;
    private double specialTraffic;
    private double selfDrive;
    private double express;
    private double daily;
    private double total;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        if (this.startDate == null) {
            this.startDate = startDate;
        } else if (this.startDate.isAfter(startDate)) {
            this.startDate = startDate;
        }
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        if (this.endDate == null) {
            this.endDate = endDate;
        } else if (this.endDate.isBefore(endDate)) {
            this.endDate = endDate;
        }
    }

    private LocalDate startDate;
    private LocalDate endDate;


    public long countOutDays() {
        return endDate.toEpochDay() - startDate.toEpochDay() + 1;
    }

    private String comment;

    public void selfCheck() throws IllegalArgumentException {
        if (total != (traffic + accommodation + meal + travel + print + team + specialTraffic + selfDrive + express + daily)) {
            throw new IllegalArgumentException(orderSN + "的分项金额与总金额不一致");
        }
    }
}
