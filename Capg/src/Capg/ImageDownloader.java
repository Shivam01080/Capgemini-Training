package Capg;



class Downloader extends Thread{
	String image;
	public Downloader(String image){
		this.image = image;
	}
	public void run() {
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Downloading " + image);
	}
}
		
class ImageDownloader {

	public static void main(String[] args) {
		String images[] = {"image1", "image2", "image3"};
		for(int i = 0; i < images.length; i++) {
			Downloader loader = new Downloader(images[i]);
			loader.start();
		}

	}

}
