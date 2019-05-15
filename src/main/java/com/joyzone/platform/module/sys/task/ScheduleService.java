package com.joyzone.platform.module.sys.task;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;


/**
 * Schedule service
 * @author Administrator
 *
 */
@Component
public class ScheduleService implements SchedulingConfigurer {

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		// TODO Auto-generated method stub

	}

}
