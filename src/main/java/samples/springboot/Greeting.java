package samples.springboot;

/**
 * Created by izeye on 15. 2. 4..
 */
public class Greeting {

	private long id;
	private String content;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public Greeting() {
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Greeting{" +
				"id=" + id +
				", content='" + content + '\'' +
				'}';
	}

}
