
public class MovieTicket {
	private int ticketNum;
	private String movie;
	private int ticketPrice;
	private String seatNum;
	private String runningTime;
	private User user;
	
	public MovieTicket() {
	}

	public MovieTicket(int ticketNum, String movie, int ticketPrice, String seatNum, String runningTime) {
		this.ticketNum = ticketNum;
		this.movie = movie;
		this.ticketPrice = ticketPrice;
		this.seatNum = seatNum;
		this.runningTime = runningTime;
	}
	
	public void TicketInfo() {
		System.out.println("티켓 번호 : " + getTicketNum());
		System.out.println("영화 제목 : " + getMovie());
		System.out.println("티켓 가격 : " + getTicketPrice());
		System.out.println("좌석 번호 : " + getSeatNum());
		System.out.println("상영 시간 : " + getRunningTime());
	}

	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

}
