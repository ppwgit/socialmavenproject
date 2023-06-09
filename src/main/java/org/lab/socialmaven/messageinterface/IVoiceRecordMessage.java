package org.lab.socialmaven.messageinterface;

public interface IVoiceRecordMessage {
	public void setDuration(int duration);
    public int getDuration();
    public void setAudioFile(String audioFile);
    public String getAudioFile();
}
