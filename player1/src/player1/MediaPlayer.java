package player1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MediaPlayer extends JPanel implements ActionListener {

	JFrame window = new JFrame("Wav Player");
	JLabel info = new JLabel("Way Player One");
	JButton addButton = new JButton("Add Music");
	JButton playButton = new JButton("Play");
	JButton stopButton = new JButton("Stop");
	Font customFont = new Font("", Font.PLAIN, 20);

	JComboBox list = new JComboBox();
	JFileChooser browser = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter(".mp3","open MP3 Files Only");

	int returnValue;
	String[] musics = new String[10];
	int index = 0;
	File selecedFile;

	File SelectedFile;
	File sound;
	AudioInputStream ais;
	Clip clip;

	MediaPlayer() {
		this.setBackground(Color.yellow);
		window.add(this);

		addButton.addActionListener(this);
		playButton.addActionListener(this);
		stopButton.addActionListener(this);

		info.setFont(new Font("", Font.ITALIC, 20));
		window.add(info, BorderLayout.PAGE_END);

		addButton.setFont(customFont);
		addButton.setBackground(Color.YELLOW);
		addButton.setForeground(Color.WHITE);
		window.add(addButton, BorderLayout.LINE_START);

		playButton.setFont(customFont);
		playButton.setBackground(Color.ORANGE);
		playButton.setForeground(Color.WHITE);
		window.add(playButton, BorderLayout.CENTER);

		stopButton.setFont(customFont);
		stopButton.setBackground(Color.RED);
		stopButton.setForeground(Color.WHITE);
		window.add(stopButton, BorderLayout.LINE_END);

		list.setBackground(Color.BLACK);
		list.setForeground(Color.CYAN);
		window.add(list, BorderLayout.PAGE_START);

		browser.setFileFilter(filter);

		window.setSize(400, 200);
		window.setLocation(200, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == addButton) {
			returnValue = browser.showOpenDialog(window);

			if (returnValue == browser.APPROVE_OPTION) {
				selecedFile = browser.getSelectedFile();
				musics[index] = selecedFile.toString();
				list.addItem("Song - " + index);
				index++;

			}
		}

		else if (ae.getSource() == playButton) {
			try {

				if (list.getSelectedIndex() == 0) {
					sound = new File(musics[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
				}

				else if (list.getSelectedIndex() == 1) {

					sound = new File(musics[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();

				} else if (list.getSelectedIndex() == 2) {

					sound = new File(musics[list.getSelectedIndex()]);
					ais = AudioSystem.getAudioInputStream(sound);
					clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);

			}
		}
			
			else if (ae.getSource() == stopButton)
			{
				clip.stop();
			}
			
		}

	}

