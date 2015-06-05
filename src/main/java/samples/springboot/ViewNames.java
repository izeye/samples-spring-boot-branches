package samples.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by izeye on 15. 6. 5..
 */
@ConfigurationProperties(prefix = "view.name", locations = "views.properties")
public class ViewNames {
	
	private String pc;
	private String mobile;

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "ViewProperties{" +
				"pc='" + pc + '\'' +
				", mobile='" + mobile + '\'' +
				'}';
	}
	
}
