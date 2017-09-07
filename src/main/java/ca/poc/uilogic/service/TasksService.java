package ca.poc.uilogic.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import ca.poc.uilogic.converters.wms.WmsTaskConverter;
import ca.poc.uilogic.domain.Task;
import ca.poc.uilogic.domain.wms.WmsTask;
import ca.poc.uilogic.domain.wms.WmsTasksList;
import ca.poc.uilogic.repository.interfaces.ITasksRepository;
import ca.poc.uilogic.service.interfaces.ITasksService;

/**
 * Service implementation for: operations on tasks.
 * 
 * @author daniel.fryze
 */
@Named("tasksService")
public class TasksService implements ITasksService {

	private ITasksRepository tasksRepository;

	@Value("${services.mode}")
	private String mode;

	@Value("${wms.tasks.url}")
	private String wmsUrl;

	@Inject
	public TasksService(@Named("tasksRepository") ITasksRepository tasksRepository) {
		this.tasksRepository = tasksRepository;
	}

	@PostConstruct
	private void init() {

		if (mode != null && "real".equals(mode)) {

			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("Authorization", "Basic QWRtaW5pc3RyYXRvcjptYW5hZ2U=");

			Map<String, String> map = new HashMap<String, String>();
			map.put("includeTaskData", "true");

			HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(map, headers);

			WmsTasksList result2 = restTemplate.postForObject(wmsUrl, request, WmsTasksList.class);

			if (result2 != null) {
				for (WmsTask wmsTask : result2.getTasksList()) {
					if (wmsTask != null && wmsTask.getTaskInfo() != null && wmsTask.getTaskInfo().getName() != null && wmsTask.getTaskInfo().getName().length() > 0) {
						tasksRepository.addTask(WmsTaskConverter.convert(wmsTask));
					}
				}
			}

		} else {

			tasksRepository.addTask(new Task("Ekstra wpływ", "Taylor Hewitt", 1506592647877L, 1505204436546L, "Oczekujący", "", false, false, false));
			tasksRepository.addTask(new Task("Ostatnia rata", "Lorraine Espinoza", 1505711506937L, 1506475453434L, "Oczekujący", "", false, true, false));
			tasksRepository.addTask(new Task("Ostatnia rata", "Rachael Burch", 1505786804933L, 1505880513707L, "Oczekujący", "", true, true, false));
			tasksRepository.addTask(new Task("Oferta powitalna", "Strickland Reed", 1504176207406L, 1506597151827L, "Oczekujący", "", false, false, true));
			tasksRepository.addTask(new Task("Ostatnia rata", "Houston Rowland", 1504245827769L, 1505515519059L, "Oczekujący", "", false, false, true));
			tasksRepository.addTask(new Task("Oferta powitalna.", "Sargent Jenkins", 1505656215878L, 1505390850236L, "Oczekujący", "", false, true, false));
			tasksRepository.addTask(new Task("Ostatnia rata", "Sharp Livingston", 1504612369300L, 1505721843040L, "Oczekujący", "", false, false, true));
			tasksRepository.addTask(new Task("Ostatnia rata", "Ballard Clayton", 1505236812104L, 1505866634598L, "Oczekujący", "", true, true, true));
			tasksRepository.addTask(new Task("Ostatnia rata", "Kitty Medina", 1505028934172L, 1506743124645L, "Oczekujący", "", true, false, false));
			tasksRepository.addTask(new Task("Oferta powitalna", "Gross Spears", 1506592001659L, 1504755523266L, "Oczekujący", "", false, true, true));
			tasksRepository.addTask(new Task("Oferta powitalna", "Jeannette Pope", 1506631052675L, 1506411285734L, "Oczekujący", "", false, true, true));
			tasksRepository.addTask(new Task("Ostatnia rata", "Lidia Cox", 1505987114166L, 1505280353021L, "Oczekujący", "", true, true, true));
			tasksRepository.addTask(new Task("Oferta powitalna", "Leblanc Larson", 1505753755386L, 1505616452777L, "Oczekujący", "", true, true, true));
			tasksRepository.addTask(new Task("Oferta powitalna", "Smith Parrish", 1504874606320L, 1504217089959L, "Oczekujący", "", true, false, false));
			tasksRepository.addTask(new Task("Ostatnia rata", "Bray Burks", 1504406413323L, 1506308911773L, "Oczekujący", "", false, false, false));
			tasksRepository.addTask(new Task("Ekstra wpływ", "Austin Mckee", 1504880140588L, 1505610603074L, "Oczekujący", "", false, false, true));
			tasksRepository.addTask(new Task("Ekstra wpływ.", "Lacey Rasmussen", 1504202800150L, 1504321866753L, "Oczekujący", "", true, true, false));
			tasksRepository.addTask(new Task("Ekstra wpływ", "Cline Chandler", 1506182255229L, 1504755074232L, "Oczekujący", "", true, true, false));
			tasksRepository.addTask(new Task("Ostatnia rata", "Wooten Grimes", 1505303169196L, 1506124914482L, "Oczekujący", "", true, true, true));
			tasksRepository.addTask(new Task("Oferta powitalna", "Sherry Moon", 1505674954197L, 1506523229254L, "Oczekujący", "", true, false, false));
			tasksRepository.addTask(new Task("Ekstra wpływ", "Mathews Harper", 1504339008266L, 1505856742371L, "Oczekujący", "", false, true, false));
			tasksRepository.addTask(new Task("Est sunt nisi aliqua Lorem.", "Autumn Jarvis", 1505893787105L, 1504577642282L, "Oczekujący", "", false, true, true));
			tasksRepository.addTask(new Task("Oferta powitalna", "Guerrero Briggs", 1506400157729L, 1506546383157L, "Oczekujący", "", false, false, false));
			tasksRepository.addTask(new Task("Oferta powitalna", "Salas Prince", 1505964621434L, 1504292526567L, "Oczekujący", "", true, false, false));
			tasksRepository.addTask(new Task("Oferta powitalna", "Lizzie Malone", 1506010451953L, 1506026039570L, "Oczekujący", "", false, true, false));
			tasksRepository.addTask(new Task("Ekstra wpływ", "Webster Franklin", 1506152012340L, 1504252952956L, "Oczekujący", "", false, true, false));
			tasksRepository.addTask(new Task("Oferta powitalna", "Georgina Jackson", 1506472067444L, 1506549219721L, "Oczekujący", "", false, false, false));
			tasksRepository.addTask(new Task("Oferta powitalna", "Carey Sharpe", 1506311187150L, 1504385590082L, "Oczekujący", "", false, true, false));
		}
	}

	public Task getTask(String id) {
		return tasksRepository.getTask(id);
	}

	public long getTasksCount() {
		return getAllTasks().size();
	}

	public List<Task> getAllTasks() {
		return tasksRepository.getTasks();
	}

	public List<Task> getUrgentTasks() {
		return tasksRepository.getTasks();
	}

	public List<Task> getExpiringTasks() {
		return tasksRepository.getTasks();
	}

	public List<Task> getCyclicalTasks() {
		return tasksRepository.getTasks();
	}

	public List<Task> getOwnTasks() {
		return tasksRepository.getTasks();
	}
}