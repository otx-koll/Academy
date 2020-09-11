package minesweeper;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

class MyFrame05 extends JFrame implements MouseListener, ActionListener {

	private Container con;

	private JPanel p1 = new JPanel();

	private JPanel p2 = new JPanel();

	private JButton startBt = new JButton("����");

	private JButton endBt = new JButton("����");

	private ImageIcon base = new ImageIcon("base.jpg");

	private ImageIcon one = new ImageIcon("one.jpg");

	private ImageIcon two = new ImageIcon("two.jpg");

	private ImageIcon three = new ImageIcon("three.jpg");

	private ImageIcon four = new ImageIcon("four.jpg");

	private ImageIcon five = new ImageIcon("five.png");

	private ImageIcon flag = new ImageIcon("flag.jpg");

	private ImageIcon bomb = new ImageIcon("bomb.jpg");

	private JMenuBar mb = new JMenuBar();

	private JMenu diff = new JMenu("���̵�");

	private JMenuItem mi1 = new JMenuItem("�ʱ�");

	private JMenuItem mi2 = new JMenuItem("�߱�");

	private JMenuItem mi3 = new JMenuItem("���");

	static int xx = 10; // ������ �ʱ�

	static int yy = 10;

	static int poksu = 10;

	private JButton[][] jbt = new JButton[10][10];

	int[][] checkboom = new int[10][10];

	int[][] pok = new int[10][10];

	public void init() {

		con = this.getContentPane(); // JFrame ���� Container�� �ø���.

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x�� ������ Ŭ���� ��Ų��.

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

	public void setting() { // ��ư�� ����

		while (true) {

			for (int i = 0; i < xx; i++) {

				for (int j = 0; j < yy; j++) {

					pok[i][j] = (int) ((Math.random() * 9) + 1);

					if (pok[i][j] != 9)

						pok[i][j] = 0;

				}

			}

			int count = 0;

			for (int i = 0; i < xx; i++) { // 9�� ��ź, ������ 9�� ã�´�.

				for (int j = 0; j < yy; j++) {

					count += findbomb(i, j, pok, 0); // ������

					count += findbomb(i, j, pok, 1); // ��

					count += findbomb(i, j, pok, 2); // ��������

					count += findbomb(i, j, pok, 3); // ����

					count += findbomb(i, j, pok, 4); // ������

					count += findbomb(i, j, pok, 5); // ���ʾƷ�

					count += findbomb(i, j, pok, 6); // �Ʒ�

					count += findbomb(i, j, pok, 7); // �����ʾƷ�

					if (pok[i][j] == 9)

						pok[i][j] = 9; // ��ź�̸� �״�� �д�.

					else

						pok[i][j] = count; // ������ ��ź ���� ����

					count = 0;

				}

			}

			for (int i = 0; i < xx; i++) {

				for (int j = 0; j < yy; j++) {

					if (pok[i][j] == 9) {

						jbt[i][j].setText("��ź");

					} else {

						jbt[i][j].setText("" + pok[i][j]);

					}

					checkboom[i][j] = 'f'; // �÷��׸� ���� �־��� ��

				}

			}

			int ct = 0; // ���̵��� ���� ��ź ���� ����

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

		int r = pok[i][j]; // �̹����� �����ϱ� ���� �κ�

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

	public int findbomb(int i, int j, int[][] pok, int k) { // ������ ��ź ������ ����

		int x = 0;

		int y = 0;

		if (k == 0) { // ������

			x = i - 1;

			y = j - 1;

		}

		if (k == 1) { // ��

			x = i - 1;

			y = j;

		}

		if (k == 2) { // ��������

			x = i - 1;

			y = j + 1;

		}

		if (k == 3) { // ����

			x = i;

			y = j - 1;

		}

		if (k == 4) { // ������

			x = i;

			y = j + 1;

		}

		if (k == 5) { // ���ʾƷ�

			x = i + 1;

			y = j - 1;

		}

		if (k == 6) { // �Ʒ�

			x = i + 1;

			y = j;

		}

		if (k == 7) { // �����ʾƷ�

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

	public void line(int i, int j, int[][] pok) { // 0�� �κ��� �׵θ��� ���ڸ� �巯����.

		if (i - 2 >= 0 && pok[i - 2][j] != 0 && pok[i - 2][j] != 9 && jbt[i - 2][j].isEnabled() != false)

			checkButton(i - 2, j);

		if (i + 2 < xx && pok[i + 2][j] != 0 && pok[i + 2][j] != 9 && jbt[i + 2][j].isEnabled() != false)

			checkButton(i + 2, j);

		if (j - 2 >= 0 && pok[i][j - 2] != 0 && pok[i][j - 2] != 9 && jbt[i][j - 2].isEnabled() != false)

			checkButton(i, j - 2);

		if (j + 2 < yy && pok[i][j + 2] != 0 && pok[i][j + 2] != 9 && jbt[i][j + 2].isEnabled() != false)

			checkButton(i, j + 2);

	}

	public void findzero(int i, int j, int[][] pok) { // 0�� �κ��� ã�� ����Լ�

		jbt[i][j].setEnabled(false);

		checkButton(i, j);

		if (i - 1 >= 0 && pok[i - 1][j] == 0 && jbt[i - 1][j].isEnabled() != false) { // ��

			line(i, j, pok);

			findzero(i - 1, j, pok);

		}

		if (i + 1 < xx && pok[i + 1][j] == 0 && jbt[i + 1][j].isEnabled() != false) { // �Ʒ�

			line(i, j, pok);

			findzero(i + 1, j, pok);

		}

		if (j - 1 >= 0 && pok[i][j - 1] == 0 && jbt[i][j - 1].isEnabled() != false) { // ����

			line(i, j, pok);

			findzero(i, j - 1, pok);

		}

		if (j + 1 < yy && pok[i][j + 1] == 0 && jbt[i][j + 1].isEnabled() != false) { // ������

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

		if (pok[x][y] == 9) { // ��ź�ΰ�

			JOptionPane.showMessageDialog(this, "��ź ����", "�޼���", JOptionPane.INFORMATION_MESSAGE);

			checkButton(x, y);

			for (int i = 0; i < xx; i++) { // ��ź�� ������ �����ʸ� ���� ��ư enable�� false��

				for (int j = 0; j < yy; j++) {

					jbt[i][j].setEnabled(false);

					jbt[i][j].removeMouseListener(this);

				}

			}

			jbt[x][y].setEnabled(true);

		} else if (pok[x][y] > 0) { // 0�� �ƴ� ����� �׳� ǥ��

			jbt[x][y].setEnabled(false);

			checkButton(x, y);

		} else if (pok[x][y] == 0) { // 0�ΰ�

			findzero(x, y, pok); // 0�̸� ���� 0���� �� �����ϴ� ����Լ� ȣ��

		}

	}

	public void difficulty(int k, int t, int poktansu) {

		xx = k;

		yy = t;

		poksu = poktansu;

		jbt = new JButton[xx][yy];

		checkboom = new int[xx][yy];

		pok = new int[xx][yy];

		con.remove(p2); // ��ư�� �� �г��� �����

		p2 = new JPanel();// �ٽ� ����

		p2.setLayout(new GridLayout(xx, yy));

		for (int i = 0; i < xx; i++) {

			for (int j = 0; j < yy; j++) {

				jbt[i][j] = new JButton();

				p2.add(jbt[i][j]);

			}

		}

		con.add("Center", p2);

		con.validate(); // ���� ���� ������Ʈ�� ȭ�鿡 ǥ��

		for (int i = 0; i < xx; i++) {

			for (int j = 0; j < yy; j++) {

				jbt[i][j].setEnabled(false);

			}

		}

	}

	public void actionPerformed(ActionEvent e) { // ���̵� ����

		if (e.getSource() == mi1) { // �ʱ�

			difficulty(10, 10, 10);

		}

		if (e.getSource() == mi2) { // �߱�

			difficulty(15, 15, 25);

		}

		if (e.getSource() == mi3) { // ���

			difficulty(20, 20, 35);

		}

	}

	@Override

	public void mouseClicked(MouseEvent e) {

// TODO Auto-generated method stub

		if (e.getSource() == startBt) { // ���۹�ư

			for (int i = 0; i < xx; i++) {

				for (int j = 0; j < yy; j++) {

					jbt[i][j].setEnabled(true);

					jbt[i][j].setIcon(base);

					jbt[i][j].addMouseListener(this);

				}

			}

			setting();

		} else if (e.getSource() == endBt) { // �����ư

			System.exit(0);

		}

		else {

			for (int i = 0; i < xx; i++) { // ��ư�� ��ǥ �˾Ƴ���

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

		int count = 0; // �� Ǯ������ �˷��ִ� �κ�

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

			JOptionPane.showMessageDialog(this, "�� Ǯ����.", "�Ϸ�", JOptionPane.INFORMATION_MESSAGE);

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


