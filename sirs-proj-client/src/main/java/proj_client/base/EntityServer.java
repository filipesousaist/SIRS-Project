package proj_client.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import proj_client.entities.Entity;

public class EntityServer implements Runnable {
	private Entity _entity;
	
	private boolean _running;
	
	public EntityServer(Entity entity) {
		_entity = entity;
	}
	
	public int getEntityId() {
		return _entity.getId();
	}
	
	public int getTimestep() {
		return _entity.getTimestep();
	}
	
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			int id = _entity.getId();
			String type = _entity.getType();
			
			_running = true;
			while (_running) {
				System.out.print(type + "_" + id + "$ ");
				List<String> words = Arrays.asList(reader.readLine().split(" "))
					.stream()
					.map(word -> word.toUpperCase())
					.collect(Collectors.toList());
				
				executeCommand(words);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void executeCommand(List<String> words) throws IOException {
		int numWords = words.size();
		if (numWords > 0) {	
			String firstWord = words.get(0);
			if (firstWord.length() > 0)
				switch (firstWord.charAt(0)) {
					case 'C':
						_entity.printConnections(); break;
					case 'I':
						_entity.printOwnInformation(); break;
					case 'O':
						_entity.printObservations(); break;
					case 'L':
						
						if (numWords == 1)
							_entity.broadcastLocationClaim(_entity.getId());
						else // At least 2 words
							try {
								_entity.broadcastLocationClaim(Integer.parseInt(words.get(1)));
							} catch (NumberFormatException e) {
								System.out.println("Invalid ID format. ID must be an integer.");
							}
						break;
					case 'Q':
						_running = false; break;
				}
		}
	}
	
}
