package minesweeper;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

class MyFrame05 extends JFrame implements MouseListener, ActionListener {

	private Container con;

	private JPanel p1 = new JPanel();

	private JPanel p2 = new JPanel();

	private JButton startBt = new JButton("시작");

	private JButton endBt = new JButton("종료");

	private ImageIcon base = new ImageIcon("base.jpg");

	private ImageIcon one = new ImageIcon("one.jpg");

	private ImageIcon two = new ImageIcon("two.jpg");

	private ImageIcon three = new ImageIcon("three.jpg");

	private ImageIcon four = new ImageIcon("four.jpg");

	private ImageIcon five = new ImageIcon("five.png");

	private ImageIcon flag = new ImageIcon("flag.jpg");

	private ImageIcon bomb = new ImageIcon("bomb.jpg");

	private JMenuBar mb = new JMenuBar();

	private JMenu diff = new JMenu("난이도");

	private JMenuItem mi1 = new JMenuItem("초급");

	private JMenuItem mi2 = new JMenuItem("중급");

	private JMenuItem mi3 = new JMenuItem("고급");

	static int xx = 10; // 시작은 초급

	static int yy = 10;

	static int poksu = 10;

	private JButton[][] jbt = new JButton[10][10];

	int[][] checkboom = new int[10][10];

	int[][] pok = new int[10][10];

	public void init() {

		con = this.getContentPane(); // JFrame 위에 Container를 올린다.

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x를 누르면 클로즈 시킨다.

		this.setJMenuBar(mb);

		mb.add(diff);

		diff.add(mi1);

		diff.add(mi2);

		diff.add(mi3);

		mi1.addActionListener(this);

		mi2.addActionListener(this);

		mi3.addActionListener(this);

		con.setLayout(new BorderLayout());

		con.add("North", p1);

		p1.setLayout(new FlowLayout());

		p1.add(startBt);

		p1.add(endBt);

		con.add("Center", p2);

		p2.setLayout(new GridLayout(xx, yy));

		for (int i = 0; i < 10; i++) {

			for (int j = 0; j < 10; j++) {

				jbt[i][j] = new JButton();

				p2.add(jbt[i][j]);

			}

		}

		startBt.addMouseListener(this);

		endBt.addMouseListener(this);

		for (int i = 0; i < xx; i++) {

			for (int j = 0; j < yy; j++) {

				jbt[i][j].setEnabled(false);

			}

		}

	}

	public void setting() { // 버튼에 세팅

		while (true) {

			for (int i = 0; i < xx; i++) {

				for (int j = 0; j < yy; j++) {

					pok[i][j] = (int) ((Math.random() * 9) + 1);

					if (pok[i][j] != 9)

						pok[i][j] = 0;

				}

			}

			int count = 0;

			for (int i = 0; i < xx; i++) { // 9가 폭탄, 주위의 9를 찾는다.

				for (int j = 0; j < yy; j++) {

					count += findbomb(i, j, pok, 0); // 왼쪽위

					count += findbomb(i, j, pok, 1); // 위

					count += findbomb(i, j, pok, 2); // 오른쪽위

					count += findbomb(i, j, pok, 3); // 왼쪽

					count += findbomb(i, j, pok, 4); // 오른쪽

					count += findbomb(i, j, pok, 5); // 왼쪽아래

					count += findbomb(i, j, pok, 6); // 아래

					count += findbomb(i, j, pok, 7); // 오른쪽아래

					if (pok[i][j] == 9)

						pok[i][j] = 9; // 폭탄이면 그대로 둔다.

					else

						pok[i][j] = count; // 조사한 폭탄 수를 세팅

					count = 0;

				}

			}

			for (int i = 0; i < xx; i++) {

				for (int j = 0; j < yy; j++) {

					if (pok[i][j] == 9) {

						jbt[i][j].setText("폭탄");

					} else {

						jbt[i][j].setText("" + pok[i][j]);

					}

					checkboom[i][j] = 'f'; // 플래그를 위해 넣어준 값

				}

			}

			int ct = 0; // 난이도에 따른 폭탄 개수 조정

			for (int i = 0; i < xx; i++) {

				for (int j = 0; j < yy; j++) {

					if (pok[i][j] == 9) {

						ct++;

					}

				}

			}

			if (ct == poksu)

				break;

		}

	}

	public void checkButton(int i, int j) {

		int r = pok[i][j]; // 이미지를 세팅하기 위한 부분

		if (r == 0) {

			jbt[i][j].setIcon(base);

			jbt[i][j].setEnabled(false);

		}

		if (r == 1) {

			jbt[i][j].setIcon(one);

			jbt[i][j].setEnabled(false);

		}

		if (r == 2) {

			jbt[i][j].setIcon(two);

			jbt[i][j].setEnabled(false);

		}

		if (r == 3) {

			jbt[i][j].setIcon(three);

			jbt[i][j].setEnabled(false);

		}

		if (r == 4) {

			jbt[i][j].setIcon(four);

			jbt[i][j].setEnabled(false);

		}

		if (r == 5) {

			jbt[i][j].setIcon(five);

			jbt[i][j].setEnabled(false);

		}

		if (r == 9) {

			jbt[i][j].setIcon(bomb);

		}

	}

	public int findbomb(int i, int j, int[][] pok, int k) { // 주위의 폭탄 개수를 구함

		int x = 0;

		int y = 0;

		if (k == 0) { // 왼쪽위

			x = i - 1;

			y = j - 1;

		}

		if (k == 1) { // 위

			x = i - 1;

			y = j;

		}

		if (k == 2) { // 오른쪽위

			x = i - 1;

			y = j + 1;

		}

		if (k == 3) { // 왼쪽

			x = i;

			y = j - 1;

		}

		if (k == 4) { // 오른쪽

			x = i;

			y = j + 1;

		}

		if (k == 5) { // 왼쪽아래

			x = i + 1;

			y = j - 1;

		}

		if (k == 6) { // 아래

			x = i + 1;

			y = j;

		}

		if (k == 7) { // 오른쪽아래

			x = i + 1;

			y = j + 1;

		}

		if (x < 0) {

			x += 1;

			return 0;

		} else if (y < 0) {

			y -= 1;

			return 0;

		} else if (x > xx - 1) {

			x += 1;

			return 0;

		} else if (y > yy - 1) {

			y -= 1;

			return 0;

		}

		if (pok[x][y] == 9)

			return 1;

		return 0;

	}

	public void line(int i, int j, int[][] pok) { // 0인 부분의 테두리에 숫자를 드러낸다.

		if (i - 2 >= 0 && pok[i - 2][j] != 0 && pok[i - 2][j] != 9 && jbt[i - 2][j].isEnabled() != false)

			checkButton(i - 2, j);

		if (i + 2 < xx && pok[i + 2][j] != 0 && pok[i + 2][j] != 9 && jbt[i + 2][j].isEnabled() != false)

			checkButton(i + 2, j);

		if (j - 2 >= 0 && pok[i][j - 2] != 0 && pok[i][j - 2] != 9 && jbt[i][j - 2].isEnabled() != false)

			checkButton(i, j - 2);

		if (j + 2 < yy && pok[i][j + 2] != 0 && pok[i][j + 2] != 9 && jbt[i][j + 2].isEnabled() != false)

			checkButton(i, j + 2);

	}

	public void findzero(int i, int j, int[][] pok) { // 0인 부분을 찾는 재귀함수

		jbt[i][j].setEnabled(false);

		checkButton(i, j);

		if (i - 1 >= 0 && pok[i - 1][j] == 0 && jbt[i - 1][j].isEnabled() != false) { // 위

			line(i, j, pok);

			findzero(i - 1, j, pok);

		}

		if (i + 1 < xx && pok[i + 1][j] == 0 && jbt[i + 1][j].isEnabled() != false) { // 아래

			line(i, j, pok);

			findzero(i + 1, j, pok);

		}

		if (j - 1 >= 0 && pok[i][j - 1] == 0 && jbt[i][j - 1].isEnabled() != false) { // 왼쪽

			line(i, j, pok);

			findzero(i, j - 1, pok);

		}

		if (j + 1 < yy && pok[i][j + 1] == 0 && jbt[i][j + 1].isEnabled() != false) { // 오른쪽

			line(i, j, pok);

			findzero(i, j + 1, pok);

		}

	}

	public MyFrame05(String title) {

		super(title);

		init();

		setSize(900, 900);

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int xpos = (int) (screen.getWidth() / 2 - this.getWidth() / 2);

		int ypos = (int) (screen.getHeight() / 2 - this.getWidth() / 2);

		setLocation(xpos, ypos);

		setResizable(false);

		setVisible(true);

	}

	public void gg(int x, int y) {

		if (pok[x][y] == 9) { // 폭탄인가

			JOptionPane.showMessageDialog(this, "폭탄 누름", "메세지", JOptionPane.INFORMATION_MESSAGE);

			checkButton(x, y);

			for (int i = 0; i < xx; i++) { // 폭탄을 누르면 리스너를 빼고 버튼 enable을 false로

				for (int j = 0; j < yy; j++) {

					jbt[i][j].setEnabled(false);

					jbt[i][j].removeMouseListener(this);

				}

			}

			jbt[x][y].setEnabled(true);

		} else if (pok[x][y] > 0) { // 0이 아닌 수라면 그냥 표시

			jbt[x][y].setEnabled(false);

			checkButton(x, y);

		} else if (pok[x][y] == 0) { // 0인가

			findzero(x, y, pok); // 0이면 주위 0까지 다 제거하는 재귀함수 호출

		}

	}

	public void difficulty(int k, int t, int poktansu) {

		xx = k;

		yy = t;

		poksu = poktansu;

		jbt = new JButton[xx][yy];

		checkboom = new int[xx][yy];

		pok = new int[xx][yy];

		con.remove(p2); // 버튼이 들어간 패널을 지우고

		p2 = new JPanel();// 다시 세팅

		p2.setLayout(new GridLayout(xx, yy));

		for (int i = 0; i < xx; i++) {

			for (int j = 0; j < yy; j++) {

				jbt[i][j] = new JButton();

				p2.add(jbt[i][j]);

			}

		}

		con.add("Center", p2);

		con.validate(); // 새로 만든 컴포넌트를 화면에 표시

		for (int i = 0; i < xx; i++) {

			for (int j = 0; j < yy; j++) {

				jbt[i][j].setEnabled(false);

			}

		}

	}

	public void actionPerformed(ActionEvent e) { // 난이도 조정

		if (e.getSource() == mi1) { // 초급

			difficulty(10, 10, 10);

		}

		if (e.getSource() == mi2) { // 중급

			difficulty(15, 15, 25);

		}

		if (e.getSource() == mi3) { // 고급

			difficulty(20, 20, 35);

		}

	}

	@Override

	public void mouseClicked(MouseEvent e) {

// TODO Auto-generated method stub

		if (e.getSource() == startBt) { // 시작버튼

			for (int i = 0; i < xx; i++) {

				for (int j = 0; j < yy; j++) {

					jbt[i][j].setEnabled(true);

					jbt[i][j].setIcon(base);

					jbt[i][j].addMouseListener(this);

				}

			}

			setting();

		} else if (e.getSource() == endBt) { // 종료버튼

			System.exit(0);

		}

		else {

			for (int i = 0; i < xx; i++) { // 버튼의 좌표 알아내서

				for (int j = 0; j < yy; j++) {

					if (jbt[i][j] == e.getSource() && e.getButton() == 1) {

						gg(i, j);

					} else if (e.getSource() == jbt[i][j] && e.getButton() == 3) {

						if (checkboom[i][j] == 'f') {

							jbt[i][j].setIcon(flag);

							checkboom[i][j] = 'n';

							jbt[i][j].setEnabled(false);

						} else {

							jbt[i][j].setIcon(base);

							checkboom[i][j] = 'f';

							jbt[i][j].setEnabled(true);

						}

					}

				}

			}

		}

		int count = 0; // 다 풀었는지 알려주는 부분

		int pokct = 0;

		for (int k = 0; k < xx; k++) {

			for (int t = 0; t < yy; t++) {

				if (jbt[k][t].isEnabled() == false) {

					count++;

				}

				if (checkboom[k][t] == 'n')

					pokct++;

			}

		}

		if (count + pokct == xx * yy + poksu) {

			JOptionPane.showMessageDialog(this, "다 풀었다.", "완료", JOptionPane.INFORMATION_MESSAGE);

			for (int k = 0; k < xx; k++) {

				for (int t = 0; t < yy; t++) {

					jbt[k][t].removeMouseListener(this);

				}

			}

		}

	}

	@Override

	public void mouseEntered(MouseEvent e) {

// TODO Auto-generated method stub

	}

	@Override

	public void mouseExited(MouseEvent e) {

// TODO Auto-generated method stub

	}

	@Override

	public void mousePressed(MouseEvent e) {

// TODO Auto-generated method stub

	}

	@Override

	public void mouseReleased(MouseEvent e) {

// TODO Auto-generated method stub

	}

}


