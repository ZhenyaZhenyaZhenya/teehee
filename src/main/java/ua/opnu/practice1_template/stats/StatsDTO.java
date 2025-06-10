package ua.opnu.practice1_template.stats;

public class StatsDTO {
  private long totalSoldTicketCount;
  private double totalRevenue;

  public StatsDTO(long totalSoldTicketCount, double totalRevenue) {
    this.totalSoldTicketCount = totalSoldTicketCount;
    this.totalRevenue = totalRevenue;
  }

  // Гетери та сетери

  public long getTotalSoldTicketCount() {
    return totalSoldTicketCount;
  }

  public void setTotalSoldTicketCount(long totalSoldTicketCount) {
    this.totalSoldTicketCount = totalSoldTicketCount;
  }

  public double getTotalRevenue() {
    return totalRevenue;
  }

  public void setTotalRevenue(double totalRevenue) {
    this.totalRevenue = totalRevenue;
  }
}
