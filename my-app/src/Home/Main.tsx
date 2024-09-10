import { lazy, useCallback, useEffect, useMemo, useReducer, useState } from "react";
import { PlayersType, useDataContext } from "../Context/DataContext"
import useFetch from "use-http";
import { AppBar, Box, Button, IconButton, Toolbar, Typography } from "@mui/material";
import styled from "styled-components";

const DropdownComp = lazy(() => import('../Components/DropdownComp'));
const TableComp = lazy(() => import('../Components/TableComp'));

export const MainApp = () => {
  const [page, setPage] = useState<number>(0);
  const [hasMore, setHasMore] = useState<boolean>(true);
  const [playerData, setPlayerData] = useState<PlayersType[]>([]);
  const [yearsData, setYearsData] = useState<number[]>([]);
  const { get, post, response, loading, error } = useFetch('/api')
  const { setAllData, setFilterData, year } = useDataContext();

  const initState = { test: 'test' };
  function reducer(state: { count: number; }, action: { type: string }) {
    switch (action.type) {
      case 'increment':
        return { count: state.count + 1 };
      case 'decrement':
        return { count: state.count - 1 };
      default:
        throw new Error();
    }
  }
  const [state, dispatcher] = useReducer(reducer, { count: 0 });

  useEffect(() => { 
    const loadInitialPlayers = async () => {
      const data = await get('/players');
      if (response.ok) setPlayerData(data)
    }
    const loadInitialYears = async () => {
      const data = await get('/players/years');
      if (response.ok) setYearsData(data)
    }
    loadInitialPlayers();
    loadInitialYears();
  }, []);

  useEffect(() => {
    if (playerData.length > 0) setAllData(playerData);
  }, [playerData]);

  useEffect(() => {
    if (year) {
      const loadSelectedData = async () => {
        const data = await post(`/players/filters`, { type: "year", birthYear: year });
        if (response.ok) setFilterData(data)
      }
      loadSelectedData();
    }
  }, [year]);

  // const loadMorePlayers = () => {
  //   const loadMore = async () => {
  //     const data = await get(`/players/paginated?page=${page + 1}&size=10`);
  //     setHasMore(data.length > 0);
  //     setPage((prevPage) => prevPage + 1);
  //     setPlayerData(playerData => [...playerData, ...data])
  //   }
  //   loadMore();
  // };

  // async function addPlayer() {
  //   const postResponse = await post('/players', { playerID: 'ryjan0014', nameFirst: 'RyJan0014', nameLast: 'Fernandes4' })
  //   if (response.ok) {
  //     setPlayerData([...playerData, postResponse])
  //   }
  // }

  const nameOptions = useMemo(() => playerData.map(player => ({ label: player.nameFirst + " " + player.nameLast, value: player.playerID })), [playerData]);
  const yearsOptions = useMemo(() => yearsData.map(year => ({ label: year, value: year })), [yearsData]);

  return (
    <>
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar>
            <Typography variant="h6">
              Players App
            </Typography>
          </Toolbar>
        </AppBar>
      </Box>
      {/* <CompStyle>
        {nameOptions.length > 0 && <DropdownComp options={nameOptions} />}
      </CompStyle> */}
      <CompStyle>
        {yearsOptions.length > 0 && <DropdownComp options={yearsOptions} />}
      </CompStyle>
      <CompStyle>
        <TableComp />
      </CompStyle>
    </>
  )
}

const CompStyle = styled.div`
  margin: 20px;
`;
