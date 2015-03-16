// This interface handles adding, deleting and updating
// all observers

public interface Subject {

	public void register(Subscriber newSubscriber);

	public void unregister(Subscriber deleteSubscriber);

	public void notifySubscriber();

}
