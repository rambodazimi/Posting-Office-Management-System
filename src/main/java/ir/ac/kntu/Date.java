package ir.ac.kntu;

public class Date {
    public enum Separator { DASH, COLON }
    private int year;
    private int month;
    private int day;
    private Separator separator = Separator.DASH;

    public Date(int year, int month, int day) {
        checkAndSetDate(year, month, day);
    }

    public Date(Date date) {
        this.year = date.year;
        this.month = date.month;
        this.day = date.day;
    }

    private void checkAndSetDate(int year, int month, int day) {
        if (checkInputs(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            this.year = 0;
            this.month = 1;
            this.day = 1;
        }
    }

    private boolean checkInputs(int year, int month, int day) {
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > 31) {
            return false;
        }
        if (month > 6 && day == 31) {
            return false;
        }
        if (month == 12 && day == 30 && !isLeapYear(year)) {
            return false;
        }
        return true;
    }

    public void setDate(int year, int month, int day) {
        checkAndSetDate(year, month, day);
    }

    public void setSeparator(Separator separator) {
        this.separator = separator;
    }

    public void setYear(int year) {
        checkAndSetDate(year, this.month, this.day);
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        checkAndSetDate(this.year, month, this.day);
    }

    public int getMonth() {
        return month;
    }

    public void setDay(int day) {
        checkAndSetDate(this.year, this.month, day);
    }

    public int getDay() {
        return day;
    }

    public String toString() {
        switch (separator) {
            case DASH:
                return year + "-" + month + "-" + day;
            case COLON:
                return year + ":" + month + ":" + day;
        }
        return year + "-" + month + "-" + day;
    }

    public Date nextDay() {
        Date curDate = new Date(this);
        Date nextDate = new Date(this);
        if (curDate.month == 12) {
            handleEsfand(curDate, nextDate);
        } else if (curDate.day < 30) {
            curDate.day++;
        } else if (curDate.day == 30 && curDate.month < 7) {
            nextDate.day++;
        } else {
            nextDate.day = 1;
            nextDate.month++;
        }
        return nextDate;
    }

    private void handleEsfand(Date curDate, Date nextDate) {
        int boundaryDay = 29;
        if (isLeapYear(curDate.year)) {
            boundaryDay = 30;
        }
        if (curDate.day == boundaryDay) {
            nextDate.year++;
            nextDate.month = 1;
            nextDate.day = 1;
        } else {
            nextDate.day++;
        }
    }

    private boolean isLeapYear(int year) {
        double a = 0.025;
        double b = 266;
        double leapDays0 = 0, leapDays1 = 0;
        int frac0 = 0, frac1 = 0;
        if (year > 0) {
            leapDays0 = ((year + 38) % 2820)*0.24219 + a;  //0.24219 ~ extra days of one year
            leapDays1 = ((year + 39) % 2820)*0.24219 + a;  //38 days is the difference of epoch to
            //2820-year cycle
        } else if (year < 0) {
            leapDays0 = ((year + 39) % 2820)*0.24219 + a;
            leapDays1 = ((year + 40) % 2820)*0.24219 + a;
        } else {
            return false;
        }

        frac0 = (int)((leapDays0 - (int)(leapDays0))*1000);
        frac1 = (int)((leapDays1 - (int)(leapDays1))*1000);

        if (frac0 <= b && frac1 > b) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Date date) {
        if (this == date) {
            return true;
        }
        if (this.year == date.year &&
                this.month == date.month &&
                this.day == date.day) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + day;
        result = prime * result + month;
        result = prime * result + year;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Date other = (Date) obj;
        if (day != other.day)
            return false;
        if (month != other.month)
            return false;
        if (year != other.year)
            return false;
        return true;
    }
}
