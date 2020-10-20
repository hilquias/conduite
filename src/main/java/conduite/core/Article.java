package conduite.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Article {

	private String slug;

	private String title;

	private String body;

	public Article() {
	}

	public Article(String slug, String title, String body) {
		this.slug = slug;
		this.title = title;
		this.body = body;
	}

	@JsonProperty
	public String getSlug() {
		return slug;
	}

	@JsonProperty
	public void setSlug(String slug) {
		this.slug = slug;
	}

	@JsonProperty
	public String getTitle() {
		return title;
	}

	@JsonProperty
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty
	public String getBody() {
		return body;
	}

	@JsonProperty
	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((slug == null) ? 0 : slug.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (slug == null) {
			if (other.slug != null)
				return false;
		} else if (!slug.equals(other.slug))
			return false;
		return true;
	}



}
