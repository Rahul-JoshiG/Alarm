package com.example.alarm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.alarm.database.Alarm;
import com.example.alarm.database.AlarmRepository;
import java.util.List;

public class AlarmListViewModel extends AndroidViewModel {
	private AlarmRepository alarmRepository;
	private LiveData<List<Alarm>> alarmsLiveData;

	public AlarmListViewModel(@NonNull Application application) {
		super(application);

		alarmRepository = new AlarmRepository(application);
		alarmsLiveData = alarmRepository.getAlarmsLiveData();
	}

	public void update(Alarm alarm) {
		alarmRepository.update(alarm);
	}

	public LiveData<List<Alarm>> getAlarmsLiveData() {
		return alarmsLiveData;
	}

	public void delete(int alarmId){
		alarmRepository.delete(alarmId);
	}
}
