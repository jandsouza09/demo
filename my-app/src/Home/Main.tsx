import { lazy, useCallback, useEffect, useMemo, useState } from "react";
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
  const { get, post, response, loading, error } = useFetch('/api')
  const { setData } = useDataContext();

  useEffect(() => { 
    const loadInitialPlayers = async () => {
      const data = await get('/players/paginated?page=0&size=10');
      if (response.ok) setPlayerData(data)
    }
    loadInitialPlayers() ;
  }, []);

  useEffect(() => {
    if (playerData.length > 0) setData(playerData);
  }, [playerData]);

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

  const options = useMemo(() => playerData.map(player => ({ label: player.nameFirst + " " + player.nameLast, value: player.playerID })), [playerData]);

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
      <CompStyle>
        {options.length > 0 && <DropdownComp options={options} />}
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
