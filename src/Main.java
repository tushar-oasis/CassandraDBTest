public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        final CassandraConnector client = new CassandraConnector();
        final String ipAddress = args.length > 0 ? args[0] : "localhost";
        final int port = args.length > 1 ? Integer.parseInt(args[1]) : 9042;
        System.out.println("Connecting to IP Address " + ipAddress + ":" + port + "...");
        client.connect(ipAddress, port);

//        final String createMovieCql =
//                "CREATE TABLE movies.moviedetails (title varchar, year int, description varchar, "
//                        + "mmpa_rating varchar, dustin_rating varchar, PRIMARY KEY (title, year))";
//        client.getSession().execute(createMovieCql);

//        final String createMovieCql =
//                "CREATE TABLE propsfinal.properties1000000 (dosname int, transidtrustee text, poolnum text, "
//                        + "distdate text, propname text, address text, city text, state text," +
//                        "zip text, county text, cssaproptype text, PRIMARY KEY (dosname));";
//        client.getSession().execute(createMovieCql);

//        final String insertRecords = "insert into props.properties10000 (dosname, transidtrustee, poolnum, distdate, propname, address, city," +
//                " state, zip, county, cssaproptype) values ('116605c6', '1166AA05C6', '343001412', '20180113', " +
//                "'1166 Avenue of the Americas', '1166 Avenue of the Americas', 'New York', 'NY', '10022', 'New York', 'OF'); ";

        long start = System.currentTimeMillis();

        for(int i=0; i<465827; i++){

            final String insertRecords = "insert into propsfinal.properties465827 (dosname, transidtrustee, poolnum, distdate, propname, address, city," +
                    " state, zip, county, cssaproptype) values ("+ Integer.toString(i) +", '1166AA05C6', '343001412', '20180113', " +
                    "'1166 Avenue of the Americas', '1166 Avenue of the Americas', 'New York', 'NY', '10022', 'New York', 'OF'); ";

            client.getSession().execute(insertRecords);

        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken for the Insert operation is: "+ (end-start) + "ms");

        client.close();

    }
}
