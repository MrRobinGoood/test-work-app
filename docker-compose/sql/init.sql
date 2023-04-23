--
-- PostgreSQL database dump
--

-- Dumped from database version 13.10
-- Dumped by pg_dump version 13.10

-- Started on 2023-04-23 19:58:47

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 21351)
-- Name: apartment; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.apartment (
    apartment_id integer NOT NULL,
    building_id integer NOT NULL,
    area double precision NOT NULL,
    count_rooms integer NOT NULL,
    apartment_floor integer NOT NULL,
    renovation character varying,
    price integer NOT NULL
);


ALTER TABLE public.apartment OWNER TO root;

--
-- TOC entry 202 (class 1259 OID 21349)
-- Name: apartment_apartment_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

ALTER TABLE public.apartment ALTER COLUMN apartment_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.apartment_apartment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 201 (class 1259 OID 21341)
-- Name: building; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.building (
    building_id integer NOT NULL,
    address character varying NOT NULL,
    date_constructed date NOT NULL,
    count_floors integer NOT NULL,
    count_entrances integer NOT NULL,
    parking boolean NOT NULL
);


ALTER TABLE public.building OWNER TO root;

--
-- TOC entry 200 (class 1259 OID 21339)
-- Name: building_building_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

ALTER TABLE public.building ALTER COLUMN building_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.building_building_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2996 (class 0 OID 21351)
-- Dependencies: 203
-- Data for Name: apartment; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.apartment (apartment_id, building_id, area, count_rooms, apartment_floor, renovation, price) FROM stdin;
1	1	34.67	2	7	черновая	2500000
2	1	58.3	3	10	черновая	5000000
3	1	82.25	4	5	от застройщика	7250000
4	2	42.9	1	14	от застройщика	5500000
5	2	52.14	2	12	черновая	6500000
6	2	86.7	4	2	от застройщика	8500000
7	3	90.2	4	7	черновая	9250000
\.


--
-- TOC entry 2994 (class 0 OID 21341)
-- Dependencies: 201
-- Data for Name: building; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.building (building_id, address, date_constructed, count_floors, count_entrances, parking) FROM stdin;
1	ул. Ленина, 16, Самара	2023-04-20	10	7	t
2	ул. Победы, 9, Самара	2019-11-07	15	4	f
3	ул. Яблоневая, 3, Самара	2017-02-15	7	10	t
\.


--
-- TOC entry 3002 (class 0 OID 0)
-- Dependencies: 202
-- Name: apartment_apartment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.apartment_apartment_id_seq', 7, true);


--
-- TOC entry 3003 (class 0 OID 0)
-- Dependencies: 200
-- Name: building_building_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.building_building_id_seq', 3, true);


--
-- TOC entry 2861 (class 2606 OID 21358)
-- Name: apartment apartment_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.apartment
    ADD CONSTRAINT apartment_pkey PRIMARY KEY (apartment_id);


--
-- TOC entry 2859 (class 2606 OID 21348)
-- Name: building building_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.building
    ADD CONSTRAINT building_pkey PRIMARY KEY (building_id);


--
-- TOC entry 2862 (class 2606 OID 21359)
-- Name: apartment apartment_building_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.apartment
    ADD CONSTRAINT apartment_building_id_fkey FOREIGN KEY (building_id) REFERENCES public.building(building_id);


-- Completed on 2023-04-23 19:58:47

--
-- PostgreSQL database dump complete
--

